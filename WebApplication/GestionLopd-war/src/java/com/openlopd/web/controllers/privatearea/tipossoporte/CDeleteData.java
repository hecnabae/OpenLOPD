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

package com.openlopd.web.controllers.privatearea.tipossoporte;

import com.openlopd.entities.lopd.TipoSoporte;
import com.openlopd.sessionbeans.lopd.TipoSoporteFacadeLocal;
import com.openlopd.web.controllers.privatearea.CSession;
import java.io.Serializable;
import java.util.Date;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Eduardo L. García Glez.
 */
public class CDeleteData implements Serializable {
    private static Logger logger = LoggerFactory.getLogger(CDeleteData.class);
    TipoSoporteFacadeLocal tipoSoporteFacade = lookupTipoSoporteFacadeLocal();
    private String id;
    private CSession session;

    public CDeleteData() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSession(CSession session) {
        this.session = session;
    }

    /**
     * Elimina una fila
     * @return <code>true</code> si la fila es eliminada correctemanete, 
     * <code>false</code> en caso contrario.
     */
    public String getDelete() {
        Long now = new Date().getTime();
        try {
            //TODO: Permisos de borrado, este sistema es inseguro cualquiera con 
            // un ID puede borrar.
            TipoSoporte ts = tipoSoporteFacade.find(id);
            if (ts.getEmpresa().equals(session.getAccessInfo().getSubEmpresa())) {
                if (ts.getFechaBaja() == null) {
                    ts.setFechaBaja(now);
                }
                ts.setBorrado(now);
                ts.setBorradoPor(session.getAccessInfo().getUserInfo().getUsuario());
                tipoSoporteFacade.edit(session.getAccessInfo(), ts);
            }            
            return "ok";
        } catch (Exception e) {
            logger.error("Error borrando la fila id{} por empresa:{}", id, 
                    session.getAccessInfo().getEmpresa().getIdEmpresa());
            return "error";
        }
    }

    private TipoSoporteFacadeLocal lookupTipoSoporteFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (TipoSoporteFacadeLocal) c.lookup("java:global/GestionLopd/GestionLopd-ejb/TipoSoporteFacade!com.openlopd.sessionbeans.lopd.TipoSoporteFacadeLocal");
        } catch (NamingException ne) {
            logger.error("Imposible obtener el bean de sesión TipoSoporteFacade.");
            throw new RuntimeException(ne);
        }
    }
}
