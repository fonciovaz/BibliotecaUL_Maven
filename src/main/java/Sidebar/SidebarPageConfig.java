/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sidebar;

/**
 *
 * @author Nobrega
 */
import java.util.List;

public interface SidebarPageConfig {
    /** get pages of this application **/
	public List<SidebarPage> getPages();
	
	/** get page **/
	public SidebarPage getPage(String name);
}
