package teste.funcional;

import java.io.FileInputStream;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;

import model.entity.Objetivo;
import model.enumerado.PerfilEnum;
import model.service.ServiceHandler;
import model.util.Constantes;

public class TesteFuncionalObjetivo extends DBTestCase {

	private FlatXmlDataSet bancoCarregado;

	@Before
	public void setUp() throws Exception
	{
		System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "org.h2.Driver" );
		System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:h2:file:~/parannus" );
		System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "admin" );
		System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "foca" );

	}

	public void testCriarObjetivo() throws Exception
	{		
		Objetivo objetivo = new Objetivo("Melhorar caso de uso");
		ServiceHandler.getInstance().manterObjetivo(objetivo);

		IDataSet dadosSetBanco1 = getConnection().createDataSet();
		ITable dadosNoBanco1 = dadosSetBanco1.getTable("objetivo");

		//remove coluna da tabela.
		ITable filteredTable1 = DefaultColumnFilter.excludedColumnsTable(dadosNoBanco1, new String[]{"id"});

		IDataSet dadosSetEsperado1 = new FlatXmlDataSetBuilder().build(new FileInputStream("/home/hugdiniz/git/parannus/Parannus/src/teste/funcional/dbUnit.xml"));
		ITable dadosEsperados1 = dadosSetEsperado1.getTable("objetivo");

		Assertion.assertEquals(dadosEsperados1, filteredTable1);
	}

	//Antes de executar o teste.
	protected DatabaseOperation getSetUpOperation() throws Exception
	{
		//RoteiroCriarsolicitacao solicitacao = new RoteiroCriarsolicitacao();
		//solicitacao.execute("teste", "T");
		return DatabaseOperation.REFRESH;		
	}

	@After
	protected DatabaseOperation getTearDownOperation() throws Exception
	{
		return DatabaseOperation.DELETE_ALL;	
		//return DatabaseOperation.NONE;
	}

	@Override
	protected void setUpDatabaseConfig(DatabaseConfig config)
	{
		config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());		
	}

	@Override
	protected IDataSet getDataSet() throws Exception
	{
		bancoCarregado = new FlatXmlDataSetBuilder().build( new FileInputStream("/home/hugdiniz/git/parannus/Parannus/src/teste/funcional/dbUnit.xml"));
		return bancoCarregado;
	}

}
