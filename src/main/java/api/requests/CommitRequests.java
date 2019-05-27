package api.requests;

import api.RestAssuredWrapper;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class CommitRequests extends RestAssuredWrapper {

    private Map<String, Object> commitConfiguration;
    private long timestamp = new Date().getTime();
    private String testFilename = "commit_test_" + timestamp + ".txt";

    public CommitRequests() throws IOException, ParseException {
        commitConfiguration = getConfigurator().getService("commit");
    }


    public String getCommitStatus(String uuid) {

        String baseUrl = getConfigurator().getBaseUrl();
        String url = baseUrl
                .concat("/" + getData("apiUsername"))
                .concat("/" + getData("projectName"))
                .concat("/commit/" + uuid);

        Response response = getRestClient()
                .get(url);

        try {
            response.then().statusCode(200);
        } catch (AssertionError e) {
            String error = response.then().contentType(ContentType.JSON).extract().response().jsonPath().getString("error");
            System.out.println(error);
            return error;
        }
        Response json = response.then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        String state = json.jsonPath().getString("state");
        System.out.println("State: " + state);
        return state;
    }

    public String createCommit() throws IOException, GitAPIException {
        File workingDirectory = File.createTempFile("repository", "");
        workingDirectory.delete();
        workingDirectory.mkdirs();

        Git git = Git.cloneRepository()
                .setURI(getData("repositoryUrl"))
                .setDirectory(workingDirectory)
                .setBranch(getData("branch"))
                .call();

        File newFile = new File(workingDirectory, testFilename);
        newFile.createNewFile();
        git.add().addFilepattern(testFilename).call();

        RevCommit rev = git.commit().setAuthor(getData("authorName"), getData("authorEmail")).setMessage("My " + timestamp + "test commit").call();
        git.push().setCredentialsProvider(new UsernamePasswordCredentialsProvider(getData("repositoryUsername"), getData("repositoryPwd"))).call();
        String[] parts = rev.getId().toString().split(" ");
        return parts[1];
    }

    private String getData(String key) {
        return commitConfiguration.get(key).toString();
    }

    public void removeTestFileFromRepository() throws IOException, GitAPIException {
        File workingDirectory = File.createTempFile("repository", "");
        workingDirectory.delete();
        workingDirectory.mkdirs();

        Git git = Git.cloneRepository()
                .setURI(getData("repositoryUrl"))
                .setDirectory(workingDirectory)
                .setBranch(getData("branch"))
                .call();

        git.rm().addFilepattern(testFilename).call();

        git.commit().setAuthor(getData("authorName"), getData("authorEmail")).setMessage("Delete test file").call();
        git.push().setCredentialsProvider(new UsernamePasswordCredentialsProvider(getData("repositoryUsername"), getData("repositoryPwd"))).call();
    }
}
