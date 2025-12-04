package Actividad;

import java.util.*;

interface Observer { void update(String m); }

class Usuario implements Observer {
 String nombre;
 Usuario(String n){ nombre = n; }
 public void update(String m){ System.out.println(nombre + ": " + m); }
}

class Notificador {
 ArrayList<Observer> lista = new ArrayList<>();
 void add(Observer o){ lista.add(o); }
 void enviar(String m){ for(Observer o : lista) o.update(m); }
}

interface Promo { double aplicar(double p); }
class Normal implements Promo { public double aplicar(double p){ return p; } }
class P10 implements Promo { public double aplicar(double p){ return p * 0.9; } }
class P50 implements Promo { public double aplicar(double p){ return p * 0.5; } }

class Calculadora {
 Promo promo;
 void set(Promo p){ promo = p; }
 double calcular(double p){ return promo.aplicar(p); }
}

interface Command { void ejecutar(); }

class TV {
 void enc(){ System.out.println("TV ON"); }
 void off(){ System.out.println("TV OFF"); }
 void up(){ System.out.println("Vol +"); }
 void down(){ System.out.println("Vol -"); }
 void canal(){ System.out.println("Canal cambiado"); }
}

class CEnc implements Command { TV t; CEnc(TV t){ this.t=t; } public void ejecutar(){ t.enc(); } }
class COff implements Command { TV t; COff(TV t){ this.t=t; } public void ejecutar(){ t.off(); } }
class CUp implements Command { TV t; CUp(TV t){ this.t=t; } public void ejecutar(){ t.up(); } }
class CDown implements Command { TV t; CDown(TV t){ this.t=t; } public void ejecutar(){ t.down(); } }
class CCanal implements Command { TV t; CCanal(TV t){ this.t=t; } public void ejecutar(){ t.canal(); } }

class Control {
 Command c;
 void set(Command c){ this.c = c; }
 void press(){ c.ejecutar(); }
}

class Sistema {
 Notificador n = new Notificador();
 Calculadora calc = new Calculadora();
 TV tv = new TV();
 Control c = new Control();

 Sistema(){
     n.add(new Usuario("Admin"));
     n.add(new Usuario("Vendedor"));
     calc.set(new Normal());
 }

 void promo10(){
     calc.set(new P10());
     n.enviar("PROMO 10% ACTIVADA");
 }

 void promo50(){
     calc.set(new P50());
     n.enviar("PROMO 50% ACTIVADA");
 }

 void comprar(double precio){
     double total = calc.calcular(precio);
     System.out.println("Total: " + total);
     n.enviar("Compra realizada: S/" + total);
 }

 void usarTV(){
     c.set(new CEnc(tv)); c.press();
     c.set(new CUp(tv));  c.press();
     c.set(new CCanal(tv)); c.press();
 }
}

