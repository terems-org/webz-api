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

/** TODO !!! describe constants !!! **/
public class WebzDefaults {

	public static final boolean FS_CACHE_ENABLED = false;
	public static final boolean USE_METADATA_INFLATABLE_FILES = false;
	public static final String FS_IMPL_CLASS = "org.terems.webz.impl.LocalFileSystemImpl";
	public static final String FS_CACHE_IMPL_CLASS = "org.terems.webz.impl.cache.ehcache.EhcacheFileSystemCache";
	public static final int FS_CACHE_PAYLOAD_THRESHOLD_BYTES = 262144;

	public static final String MIMETYPE = "application/octet-stream";
	public static final String ENCODING = "UTF-8"; // ByteOrderMark.UTF_8.getCharsetName();
	public static final boolean USE_PERMANENT_REDIRECTS = false;

	public static final String MARKDOWN_SUFFIX = ".md";
	public static final String RENDERING_TEMPLATE_PATHNAME = "/index.hbs.html";

	public static final String WELCOME_FILENAME_SUFFIXES_LIST = ".html," + MARKDOWN_SUFFIX;
	public static final String USE_PARENT_FOLDER_NAME = "..";
	public static final String WELCOME_FILENAMES_LIST = "index,README," + USE_PARENT_FOLDER_NAME;

}
