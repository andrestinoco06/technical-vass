# technical-vass
Repository for VASS LATAM technical testing

Technical testing is being developed in Liferay 7.4-ga132, Liferay Developer Studio, and JDK 21.

> [!NOTE]
> The following modules are being created:

### **```modulo register```**
This module contains the persistence created with service builder in which its ```register-api``` and ```register-service``` are included to be exposed to the ```register-web``` module

### **```register-panel-app```**
This module contains the configuration for the Panel App where the ```register-web``` portlet is exposed.

### **```register-web```**
This module contains the MVC Portlet in which the form is displayed and a view of the registered users, it also contains the **Configuration Framework** interface.


> [!CAUTION]
> Persistence with Custom Objects was needed, due to time I send it like this, I will finish it tonight