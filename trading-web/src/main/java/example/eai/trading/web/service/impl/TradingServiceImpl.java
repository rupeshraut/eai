package example.eai.trading.web.service.impl;

import java.util.Date;

import javax.jws.WebService;

import example.eai.trading.web.service.TradingService;

/**
 * The Class TradingServiceImpl.
 */
@WebService(name = "trading", serviceName = "trading", endpointInterface = "example.eai.trading.web.service.TradingService")
public class TradingServiceImpl implements TradingService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see example.eai.trading.web.service.TradingService#getDate()
	 */
	@Override
	public String getDate() {
		return new Date().toString();
	}

}
