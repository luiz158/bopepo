/*
 * Copyright 2008 JRimum Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * Created at: 30/03/2008 - 18:08:37
 * 
 * ================================================================================
 * 
 * Direitos autorais 2008 JRimum Project
 * 
 * Licenciado sob a Licença Apache, Versão 2.0 ("LICENÇA"); você não pode usar
 * esse arquivo exceto em conformidade com a esta LICENÇA. Você pode obter uma
 * cópia desta LICENÇA em http://www.apache.org/licenses/LICENSE-2.0 A menos que
 * haja exigência legal ou acordo por escrito, a distribuição de software sob
 * esta LICENÇA se dará “COMO ESTÁ”, SEM GARANTIAS OU CONDIÇÕES DE QUALQUER
 * TIPO, sejam expressas ou tácitas. Veja a LICENÇA para a redação específica a
 * reger permissões e limitações sob esta LICENÇA.
 * 
 * Criado em: 30/03/2008 - 18:08:37
 * 
 */

package org.jrimum.bopepo.campolivre;

import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;

/**
 * 
 * O campo livre do Banco do Brasil com o nosso número de 10 dígitos deve seguir
 * esta forma:
 * 
 * <table border="1" cellpadding="0" cellspacing="0" style="border-collapse:
 * collapse" bordercolor="#111111" width="60%" id="campolivre">
 * <tr>
 * <thead>
 * <th >Posição</th>
 * <th >Tamanho</th>
 * <th >Picture</th>
 * <th>Conteúdo (terminologia padrão)</th>
 * <th>Conteúdo (terminologia do banco)</th> </thead>
 * </tr>
 * <tr>
 * <td >20-25</td>
 * <td >6</td>
 * <td >9(6)</td>
 * <td >ZEROS</td>
 * <td >ZEROS</td>
 * </tr>
 * <tr>
 * <td >26-32</td>
 * <td >7</td>
 * <td >9(7)</td>
 * <td >Conta do cedente (sem dígito)</td>
 * <td >Convênio (sem dígito)</td>
 * </tr>
 * <tr>
 * <td >33-42</td>
 * <td >10</td>
 * <td >9(10)</td>
 * <td >Nosso Número</td>
 * <td >Nosso Número</td>
 * </tr>
 * <tr>
 * <td >43-44</td>
 * <td >2</td>
 * <td >9(2)</td>
 * <td >Carteira</td>
 * <td >Carteira</td>
 * </tr>
 * </table>
 * 
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * @author <a href="http://www.nordestefomento.com.br">Nordeste Fomento
 *         Mercantil</a>
 * 
 * @since JRimum 1.0
 * 
 * @version 0.2
 */
public class CLBancoDoBrasilNN10 {

	/**
	 * <p>
	 * Dado um título, cria um campo livre para o padrão do Banco do Brasil que
	 * tenha o nosso número de tamanho 10.
	 * </p>
	 * 
	 * @param titulo
	 *            título com as informações para geração do campo livre
	 */
	public static CampoLivre newCampoLivre(final Titulo titulo) {
		final ContaBancaria contaBancaria = titulo.getContaBancaria();

		final CampoLivre campoLivre = new CampoLivre(4);
		campoLivre.addZeroLeft("", 6);
		campoLivre.addZeroLeft(contaBancaria.getNumeroDaConta().getCodigoDaConta(), 7);
		campoLivre.addZeroLeft(titulo.getNossoNumero(), 10);
		campoLivre.addZeroLeft(contaBancaria.getCarteira().getCodigo(), 2);
		return campoLivre;
	}
}
