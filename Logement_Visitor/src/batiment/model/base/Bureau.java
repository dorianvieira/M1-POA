package batiment.model.base;

import batiment.model.visiteur.Visiteur;

import java.util.HashSet;
import java.util.Set;

/**
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * <p/>
 * Batiment
 * Copyright (C) 2015 Pascal Poizat (@pascalpoizat)
 * emails: pascal.poizat@lip6.fr
 */

public class Bureau implements Truc {
   public Set<Truc> trucs;//une collection de trucs qui sont dans le bureau

    public Bureau() {
        this.trucs = new HashSet<Truc>();
    }

    public void ajouter(Truc truc) {
        trucs.add(truc);
    }

    @Override
    public void accept(Visiteur v) {
        v.visit(this);
    }

  /*  @Override
    public void afficher() {
        System.out.println("je suis un bureau");
        trucs.stream().forEach(Truc::afficher);//pour chaque ellement on utilise la méthode afficher
    }
    @Override
    public void afficher2() {
        trucs.stream().forEach(Truc::afficher2);
        System.out.println("je suis un bureau");
    }*/
}
