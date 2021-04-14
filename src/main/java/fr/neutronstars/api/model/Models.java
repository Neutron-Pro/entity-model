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

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Models<T extends EntityModel>
{
    protected final Set<Class<? extends Model<T>>> models = new HashSet<>();

    private final Logger logger;

    protected Models(Logger logger)
    {
        this.logger = logger;
    }

    public Logger getLogger()
    {
        return this.logger;
    }

    public abstract List<T> gets();

    protected T loadModels(T type)
    {
        try {
            for (Class<? extends Model<T>> model : this.models) {
                type.registerModel(model);
            }
        }catch (Throwable throwable) {
            this.logger.log(Level.SEVERE, throwable.getMessage(), throwable);
        }
        return type;
    }

    public boolean hasModel(Class<? extends Model<T>> classModel)
    {
        return this.models.contains(classModel);
    }

    public Models<T> registerModel(Class<? extends Model<T>> classModel)
    {
        if (!this.hasModel(classModel)) {
            try {
                for (T type : this.gets()) {
                    type.registerModel(classModel);
                }
                this.models.add(classModel);
            } catch (Throwable throwable) {
                this.logger.log(Level.SEVERE, throwable.getMessage(), throwable);
            }
        }
        return this;
    }

    public Models<T> unRegisterModel(Class<? extends Model<T>> classModel)
    {
        for (T type : this.gets()) {
            type.unregisterModel(classModel);
        }
        this.models.remove(classModel);
        return this;
    }
}
