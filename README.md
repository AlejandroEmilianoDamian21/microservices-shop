# Microservicios Tienda

Este proyecto es una demostración de una arquitectura basada en microservicios para una tienda en línea. El sistema está diseñado con varios servicios independientes, cada uno responsable de una parte específica de la funcionalidad de la tienda. Los servicios están construidos con Spring Boot, Docker y otras tecnologías esenciales.

## Características

- **API Gateway**: Actúa como punto de entrada para todas las solicitudes, redirigiéndolas al servicio correspondiente.
- **Discovery Server**: Administra el descubrimiento de servicios para que los servicios puedan encontrarse y comunicarse entre sí dinámicamente.
- **Servicio de Inventario**: Gestiona la disponibilidad de los productos y su stock en la tienda.
- **Servicio de Pedidos**: Administra la creación, actualización y procesamiento de pedidos de los clientes.
- **Servicio de Productos**: Gestiona los detalles y el catálogo de productos.

## Tecnologías Utilizadas
- **Spring Boot:** Framework para crear microservicios basados en Java(17).
- **Docker:** Contenerización de los servicios para facilitar el despliegue y la escalabilidad.
- **Eureka:** Descubrimiento de servicios para gestionar y ubicar los servicios.
- **Spring Cloud:** Conjunto de herramientas para construir sistemas distribuidos con Spring.

## Cómo Empezar ##

Para obtener una copia local y ponerla en marcha, sigue estos pasos:

 1. Clona el repositorio: 
   ```bash
   git clone https://github.com/AlejandroEmilianoDamian21/microservices-shop.git
   
 2. Navega al directorio del proyecto
  cd microservices-shop

 3. Construye el proyecto usando Maven:
  mvn clean install

 4. Usa Docker Compose para levantar los servicios:
docker-compose up

## Arquitectura de los Servicios ## 

El sistema está diseñado usando una arquitectura de microservicios con los siguientes servicios:

**API Gateway:** Redirige las solicitudes a los servicios correspondientes.
**Discovery server:** Proporciona registro y descubrimiento de servicios.
**Servicio de Inventario:** Gestiona el inventario de productos.
**Servicio de Pedidos:** Gestiona los pedidos de los clientes.
**Servicio de Productos:** Proporciona información sobre los productos.

## Estructura del Proyecto

El proyecto está dividido en varios módulos, cada uno correspondiendo a un servicio independiente:

**api-gateway:** El gateway que gestiona las solicitudes entrantes y las redirige a los servicios correspondientes.
**discovery-server:** El servidor Eureka que facilita el descubrimiento de servicios.
**inventory-service:** El servicio que gestiona el inventario de productos.
**order-service:** El servicio que gestiona los pedidos de los clientes.
**product-service:** El servicio que maneja la información de productos.

## Configuración
El proyecto está preconfigurado con un archivo docker-compose.yml que define los servicios que se ejecutan dentro de contenedores Docker. Asegúrate de tener Docker y Docker Compose instalados antes de ejecutar el comando docker-compose up.

## Configuración de Spring Cloud Eureka
Para que los servicios se descubran entre sí, es necesario configurar los servicios con Spring Cloud Eureka. Asegúrate de que el archivo de configuración application.yml esté correctamente configurado para conectar todos los servicios al servidor Eureka.

## API
El proyecto proporciona una serie de endpoints a través de los diferentes servicios. Algunos de los principales endpoints son:

## Inventario:

GET /inventory: Obtiene todos los productos en el inventario.
POST /inventory: Añade un nuevo producto al inventario.

## Pedidos:

GET /orders: Obtiene todos los pedidos de clientes.
POST /orders: Crea un nuevo pedido.

## Productos:

GET /products: Obtiene la lista de productos disponibles en la tienda.
POST /products: Añade un nuevo producto al catálogo.
