/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.narayana.txframework.functional.ws.at.bridged;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.arjuna.mw.wst11.client.WSTXFeature;

public class ATBridgeClient {

    public static ATBridge newInstance() throws Exception {

        URL wsdlLocation = new URL("http://localhost:8080/test/ATBridgeService/ATBridge?wsdl");
        QName serviceName = new QName("http://www.jboss.com/functional/at/bridge", "ATBridgeService");
        QName portName = new QName("http://www.jboss.com/functional/at/bridge", "ATBridge");

        Service service = Service.create(wsdlLocation, serviceName);
        ATBridge client = service.getPort(portName, ATBridge.class, new WSTXFeature());

        return client;
    }
}

