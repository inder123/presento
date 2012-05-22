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
 * A strongly-typed key that associated a key name with a type
 * 
 * @author Inderjeet Singh
 *
 * @param <T> The type associated with the key
 */
public final class TypedKey<T> {
  private String key;

  public TypedKey(String key) {
    this.key = key;
  }

  @Override
  public int hashCode() {
    return key.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;

    @SuppressWarnings("unchecked")
    TypedKey<T> other = (TypedKey<T>)obj;
    return key.equals(other.key);
  }

  public String getKey() {
    return key;
  }
}
