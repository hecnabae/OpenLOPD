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

package com.openlopd.web.controllers.privatearea.soportesinventario;

import com.openlopd.entities.seguridad.base.ColumnasPermisos;
import com.openlopd.web.controllers.privatearea.AbstractWebPageController;
import java.io.Serializable;

/**
 * Controla l apágina soportesInventario.jsp
 * @author Eduardo L. García Glez.
 * @version 0.0.0 30 de dic de 2012
 */
public class CSoportesInventario extends AbstractWebPageController implements Serializable {

    public CSoportesInventario() {
        super(ColumnasPermisos.INVENTARIO_SOPORTES);
    }
    
}
