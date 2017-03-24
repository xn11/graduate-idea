package com.cebbank.gage.util;

import com.cebbank.gage.model.RegulatorsCompany;
import com.cebbank.gage.model.Staff;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.text.*;
import java.util.Date;

/**
 * Created by xn on 2017/3/15.
 */
public class RegulatorIdGenerator implements IdentifierGenerator {

    //    private static final Logger logger = Logger.getLogger("log");
    private static Logger logger = LoggerFactory.getLogger(RegulatorIdGenerator.class);
    /**
     * The FieldPosition.
     */
    private static final FieldPosition HELPER_POSITION = new FieldPosition(0);
    /**
     * This Format for format the data to special format.
     */
//    private final static Format dateFormat = new SimpleDateFormat("yyyyMM");
    /**
     * This Format for format the number tospecial format.
     */
    private final static NumberFormat numberFormat = new DecimalFormat("000");
//    private static final int MAX = 999;
    /**
     * This int is the sequence number ,the default value is 0.
     */
//    private static int seq = 0;

    /**
     * Generate a new identifier.
     *
     * @param session The session from which the request originates
     * @param object  the entity or collection (idbag) for which the id is being generated
     * @return a new identifier
     * @throws HibernateException Indicates trouble generating the identifier
     */
    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {

        RegulatorsCompany obj = (RegulatorsCompany)object;

        StringBuffer sb = new StringBuffer();
        sb.append(1);
        numberFormat.format(obj.getCompany().getId(), sb, HELPER_POSITION);
        numberFormat.format(obj.getRegulators().getId(), sb, HELPER_POSITION);
        sb.append(0);

//        logger.info("THE regulator's ID IS :" + Integer.parseInt(sb.substring(0, 10)));

        return Integer.parseInt(sb.toString());
    }
}
