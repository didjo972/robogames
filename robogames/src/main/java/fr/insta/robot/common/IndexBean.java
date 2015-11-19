//package fr.insta.robot.common;
//
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
//import javax.faces.context.FacesContext;
//import javax.faces.event.ActionEvent;
//
///** Bean de gestion de l'accueil */
//@ManagedBean(name = "index")
//@ViewScoped
//public class IndexBean {
//	
//	private String name = "toto";
//
//	public void buttonAction(ActionEvent actionEvent) {
//        addMessage("Welcome to Primefaces!!");
//    }
//     
//    public void addMessage(String summary) {
//        FacesMessage message = new FacesMessage("Hey Welcome to my first user page");
//        FacesContext.getCurrentInstance().addMessage(null, message);
//    }
//    
//    public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//}
