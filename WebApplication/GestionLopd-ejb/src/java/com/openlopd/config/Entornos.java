/*
 * OpenLOPD
 * Copyright (C) 2011  Eduardo L. García Glez <eduardo.l.g.g@gmail.com>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.openlopd.config;

/**
 * Define los entornos de ejecución de las aplicaciones.
 * 
 * Este enum permite configurar la aplicación para su funcionamiento en
 * distintos entornos de ejecución, va acompañado del fichero de configuración
 * @see com.openlopd.config.config.proterties
 * 
 * @author Eduardo L. García Glez.
 * @version 0.0.0
 */
public enum  Entornos {
    des("desarrollo"),
    pre("preexplotacion"),
    exp("explotacion");
    
    public final String id;
    
    Entornos(String id) {
        this.id = id;
    }
}
