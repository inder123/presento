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
 * Base class for all application events
 *
 * @author Inderjeet Singh
 *
 * @param <T> The parameterized type for the event.
 */
public class AppEvent<T> {
  public static final AppEvent<Object> BACK_BUTTON = new AppEvent<Object>("Back Button");
  public static final AppEvent<Object> EXIT_APP = new AppEvent<Object>("Exit App");
  private final String name;
  
  public AppEvent(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
