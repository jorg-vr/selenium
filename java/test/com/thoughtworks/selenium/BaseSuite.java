// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package com.thoughtworks.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.environment.GlobalTestEnvironment;
import org.openqa.selenium.environment.InProcessTestEnvironment;

import java.util.logging.Logger;

public class BaseSuite {

  private static final Logger log = Logger.getLogger(BaseSuite.class.getName());

  @BeforeAll
  public static void setup() {
    // testEnvironment
    log.info("Preparing test environment");
    GlobalTestEnvironment.getOrCreate(InProcessTestEnvironment::new);
    System.setProperty("webdriver.remote.shorten_log_messages", "true");


  }


  @AfterAll
  public static void teardown() {
    // browser
    log.info("Stopping browser...");
    try {
        InternalSelenseTestBase.destroyDriver();
        log.info("Browser stopped successfully.");
    } catch (SeleniumException e) {
        log.severe("Failed to stop browser: " + e.getMessage());
    }

    // testEnvironment
    log.info("Cleaning test environment...");
    try {
        GlobalTestEnvironment.stop();
        log.info("Test environment cleaned successfully.");
    } catch (Exception e) {
        log.severe("Failed to clean test environment: " + e.getMessage());
    }
}

}
