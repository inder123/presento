/*
 * Copyright (C) 2011 Inderjeet Singh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.codegoogle.presento.control;


/**
 * An interface representing the main event handler in the system.
 *
 * @author Inderjeet Singh
 */
public interface AppEventHandler {

  /**
   * Handles the specified application event.
   */
  public <T> T handleEvent(AppEvent<T> event);

  /**
   * This method is called to indicate the currently shown subscreen has
   * finished and needs to be closed.
   */
  public void subscreenFinished();
}
