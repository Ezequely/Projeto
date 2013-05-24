/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.dataAccess;

import java.util.Collection;

/**
 *
 * @author leobrizolara
 */
public interface DatabaseAccessObject {
	 public void update(Object obj);
	 public void insert(Object obj);
	 public Object search(Object obj);
	 public void remove(Object obj);
	 public Collection<Object> listAll();
}
