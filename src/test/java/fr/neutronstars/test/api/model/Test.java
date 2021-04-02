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

import fr.neutronstars.api.model.ModelException;

import java.util.Optional;

public class Test
{
    public static void main(String[] args)
    {
        /*
         * J'instancie un nouveau joueur en lui donnant un nom.
         */
        Player player = new Player("NeutronStars");
        try {
            /*
             * J'enregistre le Model qui lui est associé.
             */
            player.registerModel(PlayerModel.class);
        } catch (ModelException e) {
            /*
             * En cas d'erreur, j'attrape l'exception et l'affiche en console.
             * (Le mieux serait bien sur d'utiliser un logger)
             */
            e.printStackTrace();
        }

        /*
         * J'affiche le nom du joueur
         */
        System.out.printf("Name: %s", player.getName());

        /*
         * Je récupère l'instance du Model enregistré précédemment.
         */
        Optional<PlayerModel> playerModel = player.getModel(PlayerModel.class);

        if (playerModel.isPresent()) {
            /*
             * Si le model est trouvé alors j'affiche sa vie.
             */
            System.out.printf("Start Life: %d", playerModel.get().getLife());
            /*
             * Ensuite j'ajoute 100 points de vie.
             */
            playerModel.get().addLife(100);
            /*
             * Puis j'affiche de nouveau la vie afin de voir si les changements ont bien eu lieu.
             */
            System.out.printf("End Life: %d", playerModel.get().getLife());
        } else {
            /*
             * Si le model n'est pas trouvé alors aucune action sera faite et j'affiche un message d'erreur.
             */
            System.err.println("PlayerModel not found !");
        }
    }
}
