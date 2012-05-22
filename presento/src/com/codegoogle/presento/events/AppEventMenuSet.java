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
package com.codegoogle.presento.events;

import com.codegoogle.presento.control.AppEvent;

import android.view.Menu;

/**
 * The application raises this event when the Android menu needs to be set.
 *
 * @author Inderjeet Singh
 */
public final class AppEventMenuSet extends AppEvent<Object> {
  private final Menu menu;

  public AppEventMenuSet(Menu menu, String name) {
    super(name);
    this.menu = menu;
  }

  public Menu getMenu() {
    return menu;
  }
}
