/*
 * Copyright 2014-2015 Oleksandr Tereschenko <http://www.terems.org/>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terems.webz;

/** TODO !!! describe !!! **/
@SuppressWarnings("serial")
public class WebzException extends Exception {

	public WebzException() {
		super();
	}

	public WebzException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public WebzException(String message, Throwable cause) {
		super(message, cause);
	}

	public WebzException(String message) {
		super(message);
	}

	public WebzException(Throwable cause) {
		super(cause);
	}

}
