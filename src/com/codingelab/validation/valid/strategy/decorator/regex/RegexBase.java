/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.codingelab.validation.valid.strategy.decorator.regex;

import java.util.ArrayList;
import java.util.List;

import com.codingelab.validation.errors.Error;
/**
 * @author Abdulrahman Abdulhamid Alsaedi
 * @since 1.0.1
 *
 */
public final class RegexBase extends _Regex {

	@Override
	public boolean isValid(String input) {
		return true;
	}

	@Override
	public List<Error> getErrors(String input) {
		return new ArrayList<>();
	}

	@Override
	public String getRegex() {
		return "";
	}

	@Override
	public String typeToString() {
		return "";
	}
	public String repair(String input){
		return input;
	}
	

}
