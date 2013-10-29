package com.liferay.training;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class MyHelloWorldPortlet
 */
public class MyHelloWorldPortlet extends GenericPortlet {

    public void init() {
        editJSP = getInitParameter("edit-template");
        viewJSP = getInitParameter("view-template");
    }

    public void processAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
        throws IOException, PortletException {
    	
    	String name = actionRequest.getParameter("name");
    	PortletPreferences prefs = actionRequest.getPreferences();
    	
    	prefs.setValue("NAME", name);
    	prefs.store();
    	actionResponse.setPortletMode(PortletMode.VIEW);
//        super.processAction(actionRequest, actionResponse);
    }
    
    public void doEdit(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {
        
        include(editJSP, renderRequest, renderResponse);
    }
    
    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {
        
    	PortletPreferences prefs = renderRequest.getPreferences();
    	String defaultValue = "";
    	String name = (String)prefs.getValue("NAME", defaultValue);
    	renderRequest.setAttribute("ATTRIBUTE_NAME", name);
        include(viewJSP, renderRequest, renderResponse);
    }

    protected void include(
            String path, RenderRequest renderRequest,
            RenderResponse renderResponse)
        throws IOException, PortletException {

        PortletRequestDispatcher portletRequestDispatcher =
            getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
            _log.error(path + " is not a valid include");
        }
        else {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }
 
    protected String editJSP;
    protected String viewJSP;

    private static Log _log = LogFactoryUtil.getLog(MyHelloWorldPortlet.class);

}
