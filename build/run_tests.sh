#!/usr/bin/env bash

 cd /opt/tests/codacyTests
 mvn clean test -Dcucumber.options="${CUCUMBER_OPTIONS}"