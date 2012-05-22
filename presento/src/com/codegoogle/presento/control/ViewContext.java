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

import java.util.HashMap;
import java.util.Map;

/**
 * A class that maintains a map of name-value pairs corresponding to the current
 * view. When the view is destroyed, the context also gets destroyed.
 *
 * @author Inderjeet Singh
 */
public final class ViewContext {
  private Map<String, Object> map = new HashMap<String, Object>();
  
  public <T> void set(String key, T data) {
    map.put(key, data);
  }
  
  public <T> void set(TypedKey<T> key, T data) {
    map.put(key.getKey(), data);
  }
  
  @SuppressWarnings("unchecked")
  public <T> T get(TypedKey<T> key) {
    return (T) map.get(key.getKey());
  }

  @SuppressWarnings("unchecked")
  public <T> T get(String key) {
    return (T) map.get(key);
  }

  @Override
  public String toString() {
    return map.toString();
  }
}