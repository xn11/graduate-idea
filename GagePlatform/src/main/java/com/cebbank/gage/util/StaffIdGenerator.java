package com.cebbank.gage.util;

//import com.cebbank.gage.model.Staff;
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
public class StaffIdGenerator implements IdentifierGenerator {

//    private static final Logger logger = Logger.getLogger("log");
    private static Logger logger = LoggerFactory.getLogger(StaffIdGenerator.class);
    /**
     * The FieldPosition.
     */
    private static final FieldPosition HELPER_POSITION = new FieldPosition(0);
    /**
     * This Format for format the data to special format.
     */
    private final static Format dateFormat = new SimpleDateFormat("yyyyMM");
    /**
     * This Format for format the number tospecial format.
     */
    private final static NumberFormat numberFormat = new DecimalFormat("000");
    private static final int MAX = 999;
    /**
     * This int is the sequence number ,the default value is 0.
     */
    private static int seq = 0;
    /**
     * Generate a new identifier.
     *
     * @param session The session from which the request originates
     * @param object  the entity or collection (idbag) for which the id is being generated
     * @return a new identifier
     * @throws HibernateException Indicates trouble generating the identifier
     */
    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {

        Format sdf = new SimpleDateFormat("S");
        Date current = new Date();

        Staff staff = (Staff) object;
        Date hireDate = staff.getHireDate();
        hireDate = hireDate == null? current:hireDate;

        StringBuffer sb = new StringBuffer();
        dateFormat.format(hireDate, sb, HELPER_POSITION);
        numberFormat.format(seq, sb, HELPER_POSITION);
        sdf.format(current, sb, HELPER_POSITION);

        if (seq == MAX) {
            seq = 0;
        } else {
            seq++;
        }

//        logger.info("THE STAFF ID IS :" + Integer.parseInt(sb.substring(0, 10)));

        return Integer.parseInt(sb.substring(0, 10));
    }
}
