package br.edu.infnet.al.callcenterdpw.dto;

import org.junit.Assert;
import org.junit.Test;

public class ClienteDTOTest {

	public class ClienteTest {

		public String[] cpfVerdadeiros = {
				"111.444.777.35",
				"123.456.789.09",
				"008.689.160-05",
				"000.000.001-91",
				"000.001.001-45",
				"00000200107",
				"00020100116",
				"00003200132",
				"191",
				"1.001-45",
				"353",
				"434"};

		public String[] cpfFalsos =  {
				"11111111100",
				"1234567890d",
				"a1234567890",
				"-1234567890",
				".1345678908",
				"1234567890.",
				"1234567890-",
				"12345678900",
				"192",
				"1234567890-",
				"12345678909-",
				".12345678909-",
				"-.12345678909",
				"0",
				"00",
				"000",
				"0000",
				"00000",
				"000000",
				"0000000",
				"00000000",
				"000000000",
				"0000000000",
				"00000000000",
				"22222222222",
				"33333333333",
				"44444444444",
				"55555555555",
				"66666666666",
				"77777777777",
				"88888888888",
				"99999999999",
				"11111111111",};

		@Test
		public void validaCpfTest() {

			//Monta cenário

			//UTILIZANDO ARRAY DE STRINGS ACIMA COM OS DADOS VALIDOS E INVALIDOS
			ClienteDTO cliente1 = new ClienteDTO();

			//Execução da lógica


			//Validação do teste

			//Teste AssertTrue com dados validos
			for (String s : cpfVerdadeiros) {
				Assert.assertTrue(cliente1.validarCpf(s) );
			}

			//Teste AssertFalse com dados invalidos
			for (String s : cpfFalsos) {
				Assert.assertFalse(cliente1.validarCpf(s) );
			}
		}

	}
}
