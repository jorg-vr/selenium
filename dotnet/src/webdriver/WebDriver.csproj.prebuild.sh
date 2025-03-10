#!/bin/bash
if [[ ! -f "$1../../../bazel-bin/javascript/webdriver/atoms/get-attribute.js" ]]
then
  echo "Building getAttribute atom"
  bazel build //javascript/webdriver/atoms:get-attribute.js
fi

if [[ ! -f "$1../../../bazel-bin/javascript/atoms/fragments/is-displayed.js" ]]
then
  echo "Building isDisplayed atom"
  bazel build //javascript/atoms/fragments:is-displayed.js
fi

if [[ ! -f "$1../../../bazel-bin/javascript/atoms/fragments/find-elements.js" ]]
then
  echo "Building findElements atom"
  bazel build //javascript/atoms/fragments:find-elements.js
fi

if [[ ! -f "$1../../../bazel-bin/dotnet/src/webdriver/cdp/v85/DevToolsSessionDomains.cs" ]]
then
  echo "Generating CDP code for version 85"
  bazel build //dotnet/src/webdriver/cdp:generate-v85
fi

if [[ ! -f "$1../../../bazel-bin/dotnet/src/webdriver/cdp/v111/DevToolsSessionDomains.cs" ]]
then
  echo "Generating CDP code for version 111"
  bazel build //dotnet/src/webdriver/cdp:generate-v111
fi

if [[ ! -f "$1../../../bazel-bin/dotnet/src/webdriver/cdp/v112/DevToolsSessionDomains.cs" ]]
then
  echo "Generating CDP code for version 112"
  bazel build //dotnet/src/webdriver/cdp:generate-v112
fi

if [[ ! -f "$1../../../bazel-bin/dotnet/src/webdriver/cdp/v113/DevToolsSessionDomains.cs" ]]
then
  echo "Generating CDP code for version 113"
  bazel build //dotnet/src/webdriver/cdp:generate-v113
fi
