package api.steps;

import api.requests.CommitRequests;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.awaitility.Awaitility;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CommitServiceSteps {

    private CommitRequests commitRequests = new CommitRequests();
    private String commitUuid;

    public CommitServiceSteps() throws IOException, ParseException {
    }

    @Given("I do a commit on my project")
    public void iDoACommitOnMyProject() throws IOException, GitAPIException {
        commitUuid = commitRequests.createCommit();

    }

    @Then("I make a commit status api request and the status should be analysed")
    public void iMakeACommitStatusApiRequestAndTheStatusShouldBeAnalysed() throws IOException, GitAPIException {
        try {
            Awaitility.await().atMost(90, TimeUnit.SECONDS).with().pollInterval(1, TimeUnit.SECONDS).until(() -> commitRequests.getCommitStatus(commitUuid).equals("Analysed"));
        } catch (Exception e) {
            commitRequests.removeTestFileFromRepository();
            throw e;
        }
    }
}
