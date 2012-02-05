package controllers;

import models.fault.SysConstant;
import models.fault.Vendor;
import models.sys.District;
import models.sys.Organization;
import models.sys.SysUser;
import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.List;
import java.util.Map;

public class Application extends Controller {

    protected static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Application.class);

    static Integer pageSize = Integer.parseInt(Play.configuration.getProperty("auth.pageSize", "10"));
    //station.album.home
    static String ALBUM_HOME = Play.configuration.getProperty("station.album.home");

    /**
     * Application初始化时，载入下面全局域
     */
    // 系统启动时载入常量列表
    public static List<SysConstant> memConstList = null;
    public static List<District> memProvinces = null;
    public static List<Organization> memOrganizations=null;
    // <disId,disName>
    public static Map<String,String> memDistrictMap=null;
    public static List<Vendor> memVendors=null;

    /**
     * 初始化系统全局域
     * @return
     */
    public static String reInitialize(){
        StringBuilder buf=new StringBuilder();
        String info=refreshMemConstList();
        buf.append(info).append("<br/>");

        info=refreshMemProvinces();
        buf.append(info).append("<br/>");

        info=refreshMemOrganizations();
        buf.append(info).append("<br/>");

        info=refreshMemVendors();
        buf.append(info);

        // return to ajax dialog
        return buf.toString();
    }

    public static String refreshMemConstList(){
        memConstList= SysConstant.findAll();
        String info= "...memConstList("+memConstList.size()+") loaded in memory";
        log.info(info);
        return info;
    }

    public static String refreshMemProvinces(){
        memProvinces=District.availableProvinces();
        String info= "...available memProvinces("+memProvinces.size()+") loaded in memory";
        log.info(info);
        
        memDistrictMap=District.availableMap();
        return info;
    }

    public static String refreshMemOrganizations(){
        memOrganizations=Organization.findAll();
        String info= "...available memOrganizations("+memOrganizations.size()+") loaded in memory";
        log.info(info);
        return info;
    }

    public static String refreshMemVendors(){
        memVendors=Vendor.findAll();
        String info= "...available memVendors("+memVendors.size()+") loaded in memory";
        log.info(info);
        return info;
    }


    // ~~~~~~~~~~~~ @Before interceptors

    @Before
    static void globals() {
//        renderArgs.put("connected", connectedUser());
        renderArgs.put("pageSize", pageSize);
        renderArgs.put("memConstList", memConstList);
        renderArgs.put("memProvinces", memProvinces);
        renderArgs.put("memDistrictMap", memDistrictMap);
        renderArgs.put("memOrganizations", memOrganizations);
        renderArgs.put("memVendors", memVendors);
    }


    @Before()
    static void logAccess() {
        log.info("");
        log.info("=========================================================");
        log.info("request.url = " + request.url);
        log.info("request.controllerClass.actionMethod = " + request.controllerClass + "." + request.actionMethod);
        //        log.info("request.actionMethod = "+request.actionMethod);
        log.info("request.remoteAddress = " + request.remoteAddress);
        log.info("===============================");
    }


    @Before(unless = "login")
    static void authenticate() {
        //todo
    }

    @Before
    static void checkSecure() {
        Secure secure = getActionAnnotation(Secure.class);
//        if (secure != null) {
//            if (connectedUser() == null || (secure.admin() && !connectedUser().isAdmin())) {
//                forbidden();
//            }
//        }
    }



    // ~~~~~~~~~~~~ Actions

    public static void signup() {
        render();
    }

    public static void register(@Required @Email String email, @Required @MinSize(5) String password, @Equals("password") String password2, @Required String name) {
//        if (validation.hasErrors()) {
//            validation.keep();
//            params.flash();
//            flash.error("Please correct these errors !");
//            signup();
//        }
//        User user = new User(email, password, name);
//        try {
//            if (Notifier.welcome(user)) {
//                flash.success("Your account is created. Please check your emails ...");
//                login();
//            }
//        } catch (Exception e) {
//            Logger.error(e, "Mail error");
//        }
//        flash.error("Oops ... (the email cannot be sent)");
//        login();
    }

    public static void confirmRegistration(String uuid) {
//        User user = User.findByRegistrationUUID(uuid);
//        notFoundIfNull(user);
//        user.needConfirmation = null;
//        user.save();
//        connect(user);
//        flash.success("Welcome %s !", user.name);
//        Users.show(user.id);
    }

    public static void login() {
        render();
    }

    public static void authenticate(String email, String password) {
//        User user = User.findByEmail(email);
//        if (user == null || !user.checkPassword(password)) {
//            flash.error("Bad email or bad password");
//            flash.put("email", email);
//            login();
//        } else if (user.needConfirmation != null) {
//            flash.error("This account is not confirmed");
//            flash.put("notconfirmed", user.needConfirmation);
//            flash.put("email", email);
//            login();
//        }
//        connect(user);
//        flash.success("Welcome back %s !", user.name);
//        Users.show(user.id);
    }

    public static void logout() {
        flash.success("You've been logged out");
        session.clear();
        Welcome.index();
    }

    public static void resendConfirmation(String uuid) {
//        User user = User.findByRegistrationUUID(uuid);
//        notFoundIfNull(user);
//        try {
//            if (Notifier.welcome(user)) {
//                flash.success("Please check your emails ...");
//                flash.put("email", user.email);
//                login();
//            }
//        } catch (Exception e) {
//            Logger.error(e, "Mail error");
//        }
//        flash.error("Oops (the email cannot be sent)...");
//        flash.put("email", user.email);
//        login();
    }



    
    public static void reload(){
        renderHtml(reInitialize());
    }


    // ~~~~~~~~~~~~ Some utils

    static void connect(SysUser user) {
        session.put("logged", user.id);
    }

    static SysUser connectedUser() {
//        String userId = session.get("logged");
//        return userId == null ? null : (SysUser) SysUser.findById(Long.parseLong(userId));
        return SysUser.findById(3L);
    }
}
