/**
 * Copyright 2021 NeutronStars
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.neutronstars.api.model;

/**
 * Cette exception est lancé lorsqu'un problème survient sur un {@link Model<EntityModel>}
 */
public class ModelException extends Exception
{
    public ModelException()
    {
        super();
    }

    public ModelException(String message)
    {
        super(message);
    }

    public ModelException(Throwable cause)
    {
        super(cause);
    }

    public ModelException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ModelException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
