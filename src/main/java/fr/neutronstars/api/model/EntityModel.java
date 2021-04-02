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

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Cette class permet le support des models sur une class.
 */
public abstract class EntityModel
{
    /**
     * Liste des {@link Model<Class>} enregistrés sur cette instance.
     */
    protected final Map<
            Class<? extends Model<? extends EntityModel>>,
            Model<? extends EntityModel>
    > modelMap = new HashMap<>();

    /**
     * Permet de récupérer l'instance d'un {@link Model<Class>} enregistré.
     * @param modelClass La class du model à retourner
     * @param <T> Le type de la class du model à retourner
     * @return Un {@link Optional} avec l'instance du model si trouvé sinon null.
     */
    public <T extends Model<? extends EntityModel>> Optional<T> getModel(Class<T> modelClass)
    {
        Object object = this.modelMap.get(modelClass);
        if(modelClass.isInstance(object)) {
            return Optional.of((T) object);
        }
        return Optional.empty();
    }

    /**
     * Permet d'enregistrer un nouveau {@link Model<Class>} en rapport avec cette class.
     * @param modelClass la class du model à enregistrer.
     * @throws ModelException Si le model n'a pas pu s'instancier alors cette erreur est retourné.
     */
    public void registerModel(Class<? extends Model<? extends EntityModel>> modelClass) throws ModelException
    {
        try {
            this.modelMap.put(
                    modelClass,
                    modelClass.getDeclaredConstructor(this.getClass())
                            .newInstance(this)
            );
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new ModelException(String.format("Unable to initialize the %s.class", modelClass.getSimpleName()), e);
        }
    }

    /**
     * Permet de supprimer un {@link Model<Class>} enregistré.
     * @param modelClass la class du model à supprimer.
     */
    public void unregisterModel(Class<? extends Model<? extends EntityModel>> modelClass)
    {
        this.modelMap.remove(modelClass);
    }
}
