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

import java.io.PrintWriter;
import java.io.StringWriter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.codegoogle.presento.events.AppEventMenuItem;
import com.codegoogle.presento.events.AppEventMenuSet;
import com.codegoogle.presento.events.AppEventSwitchView;

/**
 * A base controller that handles events. You would need to write your own controller
 * that will extend this class and implement handling of additional events.
 *
 * @author Inderjeet Singh
 */
public class ViewController {
  protected final Activity activity;
  protected final ViewCreator viewCreator;
  protected ViewPresenter presenter;
  protected Menu menu;

  public ViewController(Activity activity, ViewCreator viewCreator) {
    this.activity = activity;
    this.viewCreator = viewCreator;
  }
  
  @SuppressWarnings("unchecked")
  public <T> T handleEvent(AppEvent<T> event) {
    T returnValue = null;
    try {
      if (event == AppEvent.BACK_BUTTON) {
        handleBackButton();
      } else if (event instanceof AppEventSwitchView) {
        AppEventSwitchView svEvent = (AppEventSwitchView) event;
        switchView(svEvent.getViewType(), svEvent.getContext());
      } else if (event instanceof AppEventMenuSet) {
        AppEventMenuSet mEvent = (AppEventMenuSet) event;
        setMenu(mEvent.getMenu());
      } else if (event instanceof AppEventMenuItem) {
        AppEventMenuItem miEvent = (AppEventMenuItem) event;
        returnValue = (T) (Boolean) handleMenu(miEvent.getMenuItem());
      } else if (event == AppEvent.EXIT_APP) {
        activity.finish();
      }
    } catch (Exception e) {
      handleError(e);
    }      
    return returnValue;
  }

  protected void handleError(Exception e) {
    AlertDialog.Builder builder = new AlertDialog.Builder(activity).setTitle("Internal Error");
    StringWriter writer = new StringWriter();
    PrintWriter pw = new PrintWriter(writer);
    pw.append("Exception: ").append(e.getMessage()).append("\n");
    e.printStackTrace(pw);
    builder.setMessage(writer.toString());
    builder.setPositiveButton("Exit", new OnClickListener() {
      public void onClick(DialogInterface dialog, int which) {
        dialog.dismiss();
        activity.finish();
      }          
    });
    builder.create().show();
  }
  
  private void switchView(ViewType viewType, ViewContext context) {
    ViewPresenter newPresenter = viewCreator.getView(viewType, context);
    if (newPresenter != null) {
      if (presenter != null) {
        presenter.stop();
      }
      presenter = newPresenter;
    }
    if (presenter != null) {
      presenter.start(context);
      buildMenu(viewType);
    }
  }

  private void handleBackButton() {
    if (presenter != null) {
      presenter.handleBackButton();
    }
  }

  private boolean handleMenu(MenuItem item) {
    return presenter == null ? false : presenter.handleMenu(item);
  }

  private void setMenu(Menu menu) {
    this.menu = menu;
    if (presenter != null) {
      ViewType view = presenter.getViewType();
      buildMenu(view);
    }    
  }

  private void buildMenu(ViewType viewType) {
    if (menu != null) {
      menu.clear();
      int menuId = viewType.getMenuId();
      if (menuId != -1) {
        MenuInflater inflater = activity.getMenuInflater();
        inflater.inflate(menuId, menu);
      }
    }
  }
}
