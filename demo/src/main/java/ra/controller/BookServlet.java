package ra.controller;

import ra.model.entity.Books;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/BookServlet")
public class BookServlet extends HttpServlet {
    private static List<Books> listBook = new ArrayList<>();
// Đẩy dữ liệu vào listBook


    @Override
    public void init() throws ServletException {
        Books b1 = new Books("B01", "Rừng Xà Nu",100,"NGười nào đó", true);
        Books b2 = new Books("B02", "Thép đã tôi thế đấy", 112, "Puskin",true);
        Books b3 = new Books("B03", "Nhật ký trong tù",200,"Hồ Chí Minh", true);
        listBook.add(b1);
        listBook.add(b2);
        listBook.add(b3);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//          Nhận request có menthor là GET
        String action = request.getParameter("action");
        if (action != null && action.equals("update")){
//            Thực hiện lấy thông tin sách từ bookid và hiển thị
            String bookUpdate = request.getParameter("bookId");
            for (Books b: listBook) {
                if (b.getBookId().equals(bookUpdate)) {
                    request.setAttribute("bookUpdate", b);
                    request.getRequestDispatcher("/views/UpdateBook.jsp").forward(request,response);
                    break;
                }
            }
        } else if (action != null && action.equals("delete")) {
            String bookId = request.getParameter("bookId");
            for (Books b: listBook) {
                if (b.getBookId().equals(bookId)) {
                    listBook.remove(b);
                    break;
                }
            }
            getAllBook(request,response);
        } else {
            getAllBook(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// Xử lý request có menthod = post
        String action = request.getParameter("action");
        if (action.equals("Create")) {
//            lấy thông tin từ request (create)
            String bookId = request.getParameter("bookId");
            String bookName = request.getParameter("bookName");
            float price = Float.parseFloat(request.getParameter("price"));
            String author = request.getParameter("author");
            Boolean status = Boolean.parseBoolean(request.getParameter("status"));

            Books b = new Books(bookId,bookName,price,author,status);
            listBook.add(b);
        } else if (action.equals("Update")) {
//            Thực hiện update
            String bookId = request.getParameter("bookId");
            String bookName = request.getParameter("bookName");
            float price = Float.parseFloat(request.getParameter("price"));
            String author = request.getParameter("author");
            Boolean status = Boolean.parseBoolean(request.getParameter("status"));
            for (Books b: listBook) {
                if (b.getBookId().equals(bookId)){
                    b.setBookName(bookName);
                    b.setAuthor(author);
                    b.setPrice(price);
                    b.setBookStatus(status);
                    break;
                }
            }
        }
//        Thuc hien lay lai danh sinh vien va hien thi tren trang book.jsp
        getAllBook(request,response);
    }
    public void getAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//          Trả về reponse c đầy đủ thông tin sách
//          Set listBook vào request
//          request.setAttribute("listBooks", listBook);
//  Cách 1:    Sử dụng RequestDipatcher chuyển dữ liệu sang trang jsp
//          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/book.jsp");
//          rd.forward(request,response);
//       Cách 2:
//         request.getRequestDispatcher("views/book.jsp").forward(request,response);
        //-Trả về response có đầy đủ thông tin sách
        //--Set listStudents vào request
        request.setAttribute("listBooks", listBook);
        //--Sử dụng RequestDispatcher chuyển dữ liệu sang trang jsp
//        RequestDispatcher rd = request.getRequestDispatcher("views/students.jsp");
//        rd.forward(request,response);
        request.getRequestDispatcher("views/book.jsp").forward(request, response);
    }
}

