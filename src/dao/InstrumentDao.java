package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Instrument;

public class InstrumentDao {
	
	private Connection connection;
	private final String GET_INSTRUMENTS_QUERY = "SELECT * FROM instruments";
	private final String CREATE_NEW_INSTRUMENT_QUERY = "INSERT INTO instruments(name, type, origin) VALUES(?,?,?)";
	private final String DELETE_INSTRUMENT_BY_ID_QUERY = "DELETE FROM instruments WHERE id = ?";
	
	public InstrumentDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Instrument> getInstruments() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_INSTRUMENTS_QUERY).executeQuery();
		List<Instrument> instrument = new ArrayList<Instrument>();
		
		while (rs.next()) {
			instrument.add(populateInstruments(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		
		return instrument;
	}

	private Instrument populateInstruments(int id, String name, String type, String origin) {
		return new Instrument(id, name, type, origin);
	}
	
	public void createNewInstrument(String name, String type, String origin) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_INSTRUMENT_QUERY);
		ps.setString(1, name);
		ps.setString(2, type);
		ps.setString(3, origin);
		ps.executeUpdate();
	}
	
	public void deleteInstrumentById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_INSTRUMENT_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
}
