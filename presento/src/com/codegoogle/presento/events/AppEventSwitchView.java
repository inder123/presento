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
import com.codegoogle.presento.control.ViewContext;
import com.codegoogle.presento.control.ViewType;

/**
 * An event raised by the application to switch the currently shown View to
 * the specified one.
 *
 * @author Inderjeet Singh
 */
public final class AppEventSwitchView extends AppEvent<Object> {
  private final ViewType viewType;
  private final ViewContext context;

  public AppEventSwitchView(ViewType viewType, ViewContext context) {
    super("Switch View " + viewType.getName());
    this.viewType = viewType;
    this.context = context;
  }

  public ViewType getViewType() {
    return viewType;
  }

  public ViewContext getContext() {
    return context;
  }
}
