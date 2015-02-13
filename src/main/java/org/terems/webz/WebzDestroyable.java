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
public interface WebzDestroyable {

	/**
	 * <b>ATTENTION:</b> each {@code WebzDestroyable} object should only care about releasing it's internal resources and not try to
	 * explicitly destroy any other {@code WebzDestroyable}'s (even if they are embedded in this object) as this job is supposed to be done
	 * by corresponding {@code WebzObjectFactory}.
	 **/
	public void destroy();

}
