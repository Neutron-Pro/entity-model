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

import fr.neutronstars.api.model.Model;

/*
 * Ce Model sera relier à la class Player et me permettra de lui ajouter des champs et des actions supplémentaires.
 *
 * J'ajoute un champ "vie" afin d'avoir une valeur d'exemple, ainsi que son getter/setter et add/remove.
 */
public class PlayerModel extends Model<Player>
{
    protected int life = 20;

    public PlayerModel(Player player)
    {
        super(player);
    }

    public int getLife()
    {
        return this.life;
    }

    public void setLife(int life)
    {
        this.life = life;
    }

    public void addLife(int life)
    {
        this.life += life;
    }

    public void removeLife(int life)
    {
        this.life -= life;
    }
}
