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
package fr.neutronstars.test.api.model;

import fr.neutronstars.api.model.EntityModel;

/*
 * Cet objet sera l'entité cible du test.
 *
 * J'ajoute un champ "nom" afin d'avoir une valeur d'exemple, ainsi que son getter.
 */
public class Player extends EntityModel
{
    private final String name;

    public Player(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
