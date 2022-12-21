/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAL.ChanelDAO;
import DAL.FulfillmentDAO;
import DAL.OrderDAO;
import DAL.PaymentDAO;
import Models.Chanel;
import Models.Fulfillment;
import Models.Order;
import Models.Payment;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class OrderController extends HttpServlet {

    private int payment = -1;
    private int fulfillment = -1;
    private int cod = -1;
    private int chanel = -1;
    private String textSearch = "";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get total of number/page
//        int pagesize = Integer.parseInt(request.getServletContext().getInitParameter("pagesize"));
//        String page = request.getParameter("page");
//        if (page == null || page.trim().length() <= 0) {
//            page = "1";
//        }
//        int pageindex = Integer.parseInt(page);

        //list chanel
        ChanelDAO cDao = new ChanelDAO();
        ArrayList<Chanel> listC = cDao.list();

        //list payment
        PaymentDAO pDao = new PaymentDAO();
        ArrayList<Payment> listP = pDao.list();

        //list Fulfillment
        FulfillmentDAO fDao = new FulfillmentDAO();
        ArrayList<Fulfillment> listF = fDao.list();

        OrderDAO oDao = new OrderDAO();

//        int count = oDao.count(payment, fulfillment, cod, chanel,textSearch);
//        int totalpage = (count % pagesize == 0) ? (count / pagesize)
//                : (count / pagesize) + 1;
        ArrayList<Order> listO = oDao.listSearch(payment, fulfillment, cod, chanel, textSearch);
        float total;
        for (int i = 0; i < listO.size(); i++) {
            total = 0;
            for (int j = 0; j < listO.get(i).getProducts().size(); j++) {
                total += listO.get(i).getProducts().get(j).getPrice() * listO.get(i).getProducts().get(j).getQuantity();
            }
            listO.get(i).setTotal(total);
//            response.getWriter().println(listO.get(i).getTotal());
        }
        request.setAttribute("listO", listO);
        request.setAttribute("listC", listC);
        request.setAttribute("listP", listP);
        request.setAttribute("listF", listF);

        request.setAttribute("payment", payment);
        request.setAttribute("fulfillment", fulfillment);
        request.setAttribute("cod", cod);
        request.setAttribute("chanel", chanel);

        request.getRequestDispatcher("/views/Order/OrderList.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        OrderDAO oDao = new OrderDAO();
        HttpSession session = request.getSession();

        ArrayList<Order> listO = oDao.listSearch();
        float total;
        for (int i = 0; i < listO.size(); i++) {
            total = 0;
            for (int j = 0; j < listO.get(i).getProducts().size(); j++) {
                total += listO.get(i).getProducts().get(j).getPrice() * listO.get(i).getProducts().get(j).getQuantity();
            }
            listO.get(i).setTotal(total);
//            response.getWriter().println(listO.get(i).getTotal());
        }
        Order o = new Order();
        int oid;
        switch (action) {
            case "Search":
                payment = Integer.parseInt(request.getParameter("payment"));
                fulfillment = Integer.parseInt(request.getParameter("fulfillment"));
                cod = Integer.parseInt(request.getParameter("cod"));
                chanel = Integer.parseInt(request.getParameter("chanel"));
                textSearch = request.getParameter("textSearch");
                doGet(request, response);
                break;
            case "cancel":
                oid = Integer.parseInt(request.getParameter("oid"));
                oDao.canelOrder(oid);
                session.setAttribute("message", "Cancel Order Successful!");
                doGet(request, response);
                break;
            case "edit":
                //list payment
                PaymentDAO pDao = new PaymentDAO();
                ArrayList<Payment> listP = pDao.list();

                //list Fulfillment
                FulfillmentDAO fDao = new FulfillmentDAO();
                ArrayList<Fulfillment> listF = fDao.list();

                oid = Integer.parseInt(request.getParameter("oid"));
                for (Order order : listO) {
                    if (oid == order.getId()) {
                        o = order;
                    }
                }
                request.setAttribute("order", o);
                request.setAttribute("listP", listP);
                request.setAttribute("listF", listF);
                request.getRequestDispatcher("/views/Order/OrderDetails.jsp").forward(request, response);
                break;
            case "save":
                o = new Order();
                int newPayment = Integer.parseInt(request.getParameter("payment"));
                int newFulfill = Integer.parseInt(request.getParameter("fulfillment"));
                String newDes = request.getParameter("des");

                if (newFulfill == 22) {
                    newPayment = 12;
                }

                oid = Integer.parseInt(request.getParameter("oid"));
                o.setId(oid);

                Payment newP = new Payment();
                newP.setId(newPayment);
                o.setPayment(newP);

                Fulfillment newFulf = new Fulfillment();
                newFulf.setId(newFulfill);
                o.setFulfillment(newFulf);
                
                o.setDescription(newDes);

                oDao.update(o);

                session.setAttribute("message", "Update successfull");
                doGet(request, response);
                break;
            case "add":
                request.getRequestDispatcher("/views/Order/NewOrder.jsp").forward(request, response);
                break;
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
