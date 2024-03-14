import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // 1. agregar, eliminar, buscar pór categoria,listar inventario, 6  salir
        String option = "";
        Inventario objInventario = new Inventario();
        int id = 1;
        do {
            option = JOptionPane.showInputDialog("1. agregar producto\n"+
                    "2. eliminar\n"+
                    "3. Buscar por categoria\n"+
                    "4. Listar inventario\n"+
                    "5. salir"

            );


            switch (option) {
                case "1":
                        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");
                        String precio = JOptionPane.showInputDialog("Ingrese el precio del producto: ");
                        String categoria = JOptionPane.showInputDialog("Ingrese la categoria del producto: ");
                        String marca = JOptionPane.showInputDialog("Ingrese la marca del producto: ");

                        ProductoEspecifico objProducto = new ProductoEspecifico(id, nombre, Integer.parseInt(precio), categoria, marca);
                        id++;
                        objInventario.agregarProductos(objProducto);
                    break;
                case "2":
                    objInventario.listarProductos();
                    String eliminadoInput = JOptionPane.showInputDialog("Digite el id para eliminar el producto: ");
                    objInventario.eliminarProducto(Integer.parseInt(eliminadoInput));
                    break;
                case "3":
                    String buscado = JOptionPane.showInputDialog("Ingresa el nombre de la categoria para buscar: ");
                    if (objInventario.buscarPorCategoria(buscado) == null) {
                        System.out.println("No se encontró");
                    } else {
                        System.out.println(objInventario.buscarPorCategoria(buscado));
                    }

                    break;
                case "4":

                    objInventario.listarProductos();
            }
        }while (!option.equals("5"));



        ProductoEspecifico objProducto = new ProductoEspecifico(1,"lapiz",2000,"papeleria","big");
        ProductoEspecifico objProducto2 = new ProductoEspecifico(2,"cuaderno",6000,"papeleria","norma");


        objInventario.agregarProductos(objProducto2);

        System.out.println("antes de eliminar");
        objInventario.listarProductos();
        objInventario.eliminarProducto(2);
        System.out.println("despues de eliminar");
        objInventario.listarProductos();

        System.out.println(objInventario.buscarPorNombre("lapiz"));
    }
}