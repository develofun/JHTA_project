import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.AccessToken;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.PagedDataList;
import com.siot.IamportRestClient.response.Payment;
import com.siot.IamportRestClient.response.PaymentCancelDetail;

import net.stylesolo.www.IamportRestClient.IamportClient;

/**
 * Unit test for simple App.
 */
public class IamportRestTest {
	
	IamportClient client;
	
	@Before
	public void setup() {
		String test_api_key = "imp_apikey";
		String test_api_secret = "ekKoeW8RyKuT0zgaZsUtXXTLQ4AhPFW3ZGseDA6bkA5lamv9OqDMnxyeB9wqOsuO9W3Mx9YSJ4dTqJ3f";
		client = new IamportClient(test_api_key, test_api_secret);
	}
	
	@Test
	public void testGetToken() {
		IamportResponse<AccessToken> auth_response = client.getAuth();
		assertNotNull(auth_response.getResponse());
		assertNotNull(auth_response.getResponse().getToken());
	}
	
	@Test
	public void testPaymentByImpUid() {
		String test_imp_uid = "imp_448280090638";
		IamportResponse<Payment> payment_response = client.paymentByImpUid(test_imp_uid);
		assertNotNull(payment_response.getResponse());
		assertEquals(test_imp_uid, payment_response.getResponse().getImpUid());
		
		String test_imp_uid_cancelled = "imp_138841716839";
		IamportResponse<Payment> cancelled_response = client.paymentByImpUid(test_imp_uid_cancelled);
		Payment cancelled = cancelled_response.getResponse();
		PaymentCancelDetail[] cancelDetail = cancelled.getCancelHistory();
		
		assertEquals(cancelDetail.length, 1);
		assertNotNull(cancelDetail[0].getPgTid());
	}
	
	@Test
	public void testPaymentsByStatusAll() {
		IamportResponse<PagedDataList<Payment>> r_response = client.paymentsByStatus("ready");
		IamportResponse<PagedDataList<Payment>> p_response = client.paymentsByStatus("paid");
		IamportResponse<PagedDataList<Payment>> f_response = client.paymentsByStatus("failed");
		IamportResponse<PagedDataList<Payment>> c_response = client.paymentsByStatus("cancelled");
		IamportResponse<PagedDataList<Payment>> all_response = client.paymentsByStatus("all");
		
		assertNotNull(all_response.getResponse());
		assertNotNull(r_response.getResponse());
		assertNotNull(p_response.getResponse());
		assertNotNull(f_response.getResponse());
		assertNotNull(c_response.getResponse());
		
		assertTrue(all_response.getResponse().getTotal() == 
					r_response.getResponse().getTotal() + p_response.getResponse().getTotal() + f_response.getResponse().getTotal() + c_response.getResponse().getTotal());
	}
	
	@Test
	public void testCancelPaymentAlreadyCancelledImpUid() {
		String test_already_cancelled_imp_uid = "imp_448280090638";
		CancelData cancel_data = new CancelData(test_already_cancelled_imp_uid, true); //imp_uid를 통한 전액취소
		IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
		
		assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
	}
	
	@Test
	public void testCancelPaymentAlreadyCancelledMerchantUid() {
		String test_already_cancelled_merchant_uid = "merchant_1448280088556";
		CancelData cancel_data = new CancelData(test_already_cancelled_merchant_uid, false); //merchant_uid를 통한 전액취소
		IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
		
		assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
		System.out.println(payment_response.getMessage());
	}
	
	@Test
	public void testPartialCancelPaymentAlreadyCancelledImpUid() {
		String test_already_cancelled_imp_uid = "imp_448280090638";
		CancelData cancel_data = new CancelData(test_already_cancelled_imp_uid, true, BigDecimal.valueOf(500)); //imp_uid를 통한 500원 부분취소
		IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
		
		assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
		System.out.println(payment_response.getMessage());
	}
	
	@Test
	public void testPartialCancelPaymentAlreadyCancelledMerchantUid() {
		String test_already_cancelled_merchant_uid = "merchant_1448280088556";
		CancelData cancel_data = new CancelData(test_already_cancelled_merchant_uid, false, BigDecimal.valueOf(500)); //merchant_uid를 통한 500원 부분취소
		IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
		
		assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
		System.out.println(payment_response.getMessage());
	}
	
	@Test
	public void testCancelVbankPaymentAlreadyCancelledImpUid() {
		String test_already_cancelled_imp_uid = "imp_1416557733458";
		CancelData cancel_data = new CancelData(test_already_cancelled_imp_uid, true, BigDecimal.valueOf(500)); //imp_uid를 통한 500원 부분취소
		IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
		
		assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
		System.out.println(payment_response.getMessage());
	}
	
	@Test
	public void testPartialCancelVbankPaymentAlreadyCancelledMerchantUid() {
		String test_already_cancelled_merchant_uid = "merchant_1416557727868";
		CancelData cancel_data = new CancelData(test_already_cancelled_merchant_uid, false, BigDecimal.valueOf(500)); //merchant_uid를 통한 500원 부분취소
		IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
		
		assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
		System.out.println(payment_response.getMessage());
	}
	
//	@Test
//	public void testOnetimePayment() {
//		CardInfo card = new CardInfo("1234123412341234", "201901", "801231", "00");
//		OnetimePaymentData onetime_data = new OnetimePaymentData(getRandomMerchantUid(), BigDecimal.valueOf(1004), card);
//		onetime_data.setName("ActiveX없는결제테스트");
//		onetime_data.setBuyerName("구매자");
//		onetime_data.setBuyerEmail("iamport@siot.do");
//		onetime_data.setBuyerTel("16705176");
//		
//		IamportResponse<Payment> payment_response = client.onetimePayment(onetime_data);
//		assertEquals(payment_response.getResponse().getStatus(), "paid");
//	}
//	
//	@Test
//	public void testAgainPayment() {
//		String test_customer_uid = "customer_123456";
//		CardInfo card = new CardInfo("1234123412341234", "201901", "801231", "00");
//		OnetimePaymentData onetime_data = new OnetimePaymentData(getRandomMerchantUid(), BigDecimal.valueOf(1004), card);
//		onetime_data.setName("최초결제테스트");
//		onetime_data.setBuyerName("구매자");
//		onetime_data.setBuyerEmail("iamport@siot.do");
//		onetime_data.setBuyerTel("16705176");
//		onetime_data.setCustomer_uid(test_customer_uid); //결제 성공 후 customer_123456 라는 customer_uid로 빌링키 등록
//		
//		IamportResponse<Payment> payment_response = client.onetimePayment(onetime_data);
//		assertEquals(payment_response.getResponse().getStatus(), "paid");
//		
//		try {
//			//3초 후 customer_uid로 재결제
//			Thread.sleep(3000);
//			
//			AgainPaymentData again_data = new AgainPaymentData(test_customer_uid, getRandomMerchantUid(), BigDecimal.valueOf(1005));
//			payment_response = client.againPayment(again_data);
//			assertEquals(payment_response.getResponse().getStatus(), "paid");
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testSubscribeScheduleAndUnschedule() {
//		String test_customer_uid = "customer_123456";
//		ScheduleData schedule_data = new ScheduleData(test_customer_uid);
//		
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.YEAR, 2018);
//		cal.set(Calendar.MONTH, Calendar.OCTOBER);
//		cal.set(Calendar.DAY_OF_MONTH, 25);
//		Date d1 = cal.getTime();
//		
//		cal.set(Calendar.YEAR, 2018);
//		cal.set(Calendar.MONTH, Calendar.NOVEMBER);
//		cal.set(Calendar.DAY_OF_MONTH, 25);
//		Date d2 = cal.getTime();
//		
//		cal.set(Calendar.YEAR, 2018);
//		cal.set(Calendar.MONTH, Calendar.DECEMBER);
//		cal.set(Calendar.DAY_OF_MONTH, 25);
//		Date d3 = cal.getTime();
//	
//		schedule_data.addSchedule(new ScheduleEntry(getRandomMerchantUid(), d1, BigDecimal.valueOf(1004)));
//		schedule_data.addSchedule(new ScheduleEntry(getRandomMerchantUid(), d2, BigDecimal.valueOf(1005)));
//		schedule_data.addSchedule(new ScheduleEntry(getRandomMerchantUid(), d3, BigDecimal.valueOf(1006)));
//		
//		System.out.println("예약 요청");
//		IamportResponse<List<Schedule>> schedule_response = client.subscribeSchedule(schedule_data);
//		
//		List<Schedule> schedules = schedule_response.getResponse();
//		List<ScheduleEntry> req_schedules = schedule_data.getSchedules();
//		
//		for (int i = 0; i < 3; i++) {
//			assertEquals(schedules.get(i).getCustomerUid(), test_customer_uid);
//			assertEquals(schedules.get(i).getMerchantUid(), req_schedules.get(i).getMerchantUid());
//			assertDateEquals(schedules.get(i).getScheduleAt(), req_schedules.get(i).getScheduleAt());
//			assertEquals(schedules.get(i).getAmount(), req_schedules.get(i).getAmount());
//		}
//		
//		try {
//			//1초 후 등록된 예약 unschedule by multiple merchant_uid
//			Thread.sleep(1000);
//			System.out.println("복수 merchant_uid 예약 취소 요청");
//			UnscheduleData unschedule_data = new UnscheduleData(test_customer_uid);
//			unschedule_data.addMerchantUid( req_schedules.get(0).getMerchantUid() );
//			unschedule_data.addMerchantUid( req_schedules.get(2).getMerchantUid() );
//			
//			IamportResponse<List<Schedule>> unschedule_response = client.unsubscribeSchedule(unschedule_data);
//			List<Schedule> cancelled_schedule = unschedule_response.getResponse();
//			
//			assertNotNull(cancelled_schedule);
//			assertEquals(cancelled_schedule.get(0).getMerchantUid(), req_schedules.get(0).getMerchantUid());
//			assertEquals(cancelled_schedule.get(1).getMerchantUid(), req_schedules.get(2).getMerchantUid());
//			
//			//1초 후 등록된 예약 unschedule by single multiple_uid
//			Thread.sleep(1000);
//			System.out.println("단일 merchant_uid 예약 취소 요청");
//			unschedule_data = new UnscheduleData(test_customer_uid);
//			unschedule_data.addMerchantUid( req_schedules.get(1).getMerchantUid());
//			
//			unschedule_response = client.unsubscribeSchedule(unschedule_data);
//			cancelled_schedule = unschedule_response.getResponse();
//			
//			assertNotNull(cancelled_schedule);
//			assertEquals(cancelled_schedule.get(0).getMerchantUid(), req_schedules.get(1).getMerchantUid());
//			
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testSubscribeDuplicatedSchedule() {
//		String test_customer_uid = "iamportjangbora";
//		ScheduleData schedule_data = new ScheduleData(test_customer_uid);
//		
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.YEAR, 2018);
//		cal.set(Calendar.MONTH, Calendar.OCTOBER);
//		cal.set(Calendar.DAY_OF_MONTH, 25);
//		Date d1 = cal.getTime();
//		
//		cal.set(Calendar.YEAR, 2018);
//		cal.set(Calendar.MONTH, Calendar.NOVEMBER);
//		cal.set(Calendar.DAY_OF_MONTH, 25);
//		Date d2 = cal.getTime();
//		
//		cal.set(Calendar.YEAR, 2018);
//		cal.set(Calendar.MONTH, Calendar.DECEMBER);
//		cal.set(Calendar.DAY_OF_MONTH, 25);
//		Date d3 = cal.getTime();
//	
//		schedule_data.addSchedule(new ScheduleEntry("scheduled_merchant_1$$$", d1, BigDecimal.valueOf(1004)));
//		schedule_data.addSchedule(new ScheduleEntry("scheduled_merchant_2$$$", d2, BigDecimal.valueOf(1005)));
//		schedule_data.addSchedule(new ScheduleEntry("scheduled_merchant_3$$$", d3, BigDecimal.valueOf(1006)));
//		
//		IamportResponse<List<Schedule>> schedule_response = client.subscribeSchedule(schedule_data);
//		
//		assertEquals(1, schedule_response.getCode()); //중복된 merchant_uid이므로 schedule에 실패함
//	}
	
	private String getRandomMerchantUid() {
		DateFormat df = new SimpleDateFormat("$$hhmmssSS");
		int n = (int) (Math.random() * 100) + 1;
		
		return df.format(new Date()) + "_" + n;
	}
	
	private void assertDateEquals(Date d1, Date d2) {
		assertEquals(d1.getTime() / 1000L, d2.getTime() / 1000L);
	}
}
