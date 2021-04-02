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
 * Les models permettent d'enregistrer des données supplémentaire à des instances cibles.
 *
 * @param <T> Le type d'instance qui sera ciblé par le model.
 */
public abstract class Model<T extends EntityModel>
{
    /**
     * L'instance de la cible du model.
     */
    protected final T entityModel;

    /**
     * Permet de créer le model via la méthode {@link EntityModel#registerModel(Class)}
     * @param entityModel L'instance de la cible du model
     */
    protected Model(T entityModel)
    {
        this.entityModel = entityModel;
    }

    /**
     * Permet de récupérer l'instance de la cible.
     * @return l'instance de la cible du model
     */
    public T get()
    {
        return this.entityModel;
    }
}
