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
package com.codegoogle.presento.view;

import com.codegoogle.presento.control.AppEventHandler;

import android.view.View;

/**
 * A utility class for a View {@link OnCLickListener} that indicates that
 * the subscreen should be closed on click.
 * 
 * @author Inderjeet Singh
 */
public final class ExitFromSubscreenListener implements View.OnClickListener {
  private final AppEventHandler appEventHandler;
  
  public ExitFromSubscreenListener(AppEventHandler appEventHandler) {
    this.appEventHandler = appEventHandler;
  }
  
  public void onClick(View v) {
    appEventHandler.subscreenFinished();
  }
}