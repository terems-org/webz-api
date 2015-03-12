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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * {@code WebzByteArrayOutputStream} is an extension of {@code java.io.ByteArrayOutputStream} class that lets us create
 * {@code ByteArrayInputStream} instances backed by it's internal byte-array buffer <b>directly</b> (see {@link #createInputStream()}) and
 * avoid copying of the whole buffer content, which usually happens when traditional {@link #toByteArray()} is called.
 **/
public class WebzByteArrayOutputStream extends ByteArrayOutputStream {

	/**
	 * Creates an instance of {@code java.io.ByteArrayInputStream} backed by the internal byte-array buffer of the current
	 * {@code WebzByteArrayOutputStream} instance.
	 * <p>
	 * <b>NOTE:</b> {@code WebzByteArrayOutputStream} instance should not be written to after {@code ByteArrayInputStream} instance(s)
	 * is(are) created from it - otherwise the state of created {@code ByteArrayInputStream} instance(s) will be undefined...
	 * 
	 * @return newly created {@code ByteArrayInputStream} instance.
	 **/
	public ByteArrayInputStream createInputStream() {
		return new ByteArrayInputStream(this.buf, 0, this.count);
	}

	/** TODO !!! describe !!! **/
	public byte[] getInternalByteArray() {
		return this.buf;
	}

	/**
	 * @see java.io.ByteArrayOutputStream#ByteArrayOutputStream()
	 */
	public WebzByteArrayOutputStream() {
		super();
	}

	/**
	 * @see java.io.ByteArrayOutputStream#ByteArrayOutputStream(int)
	 */
	public WebzByteArrayOutputStream(int size) {
		super(size);
	}

}
