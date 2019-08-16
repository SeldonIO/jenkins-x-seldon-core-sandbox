/*******************************************************************************
 * Copyright 2017 Seldon Technologies Ltd (http://www.seldon.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package io.seldon.apife.kafka;

import org.apache.kafka.common.serialization.Serializer;

import io.seldon.protos.PredictionProtos.RequestResponse;

public class RequestResponseSerializer extends Adapter implements Serializer<RequestResponse> {

	@Override
	public byte[] serialize(final String topic, final RequestResponse data) {
		return data.toByteArray();
	}

}
