package Model;
import java.awt.event.KeyEvent;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public final class TxtSomenteNum extends JFormattedTextField {
		private int maximoCaracteres;
		public TxtSomenteNum(int maximo) {
		        super();
		        setMaximoCaracteres(maximo);
		        addKeyListener(new java.awt.event.KeyAdapter() {
		            @Override
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        jTextFieldKeyTyped(evt);}});
		    }
		private void jTextFieldKeyTyped(KeyEvent evt) {		
			String caracteres="0987654321";// lista de caracters que n�o devem ser aceitos
		if(!caracteres.contains(evt.getKeyChar()+"")){
		// se o caracter que gerou o evento estiver n�o estiver na lista
			//aciona esse propriedade para eliminar a a��o do evento
		evt.consume();
		}
		if((getText().length()>=getMaximoCaracteres())&&(getMaximoCaracteres()!=-1)){
		//if para saber se precisa verificar tamb�m o tamanho da string do campo
			// maior ou igual ao tamanho m�ximo, cancela e nao deixa inserir mais
		evt.consume();
		setText(getText().substring(0,getMaximoCaracteres()));
		// esta linha acima � para remover os caracters inv�lidos caso o usu�rio tenha
			//copiado o conte�do de algum lugar, ou seja, com tamanho maior que o definido
		}
		        }

		    public int getMaximoCaracteres() {
		        return maximoCaracteres;
		    }
		    public void setMaximoCaracteres(int maximoCaracteres) {
		        this.maximoCaracteres = maximoCaracteres;
		    }
		}