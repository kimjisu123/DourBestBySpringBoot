package com.won.dourbest.user.signup.Controller;

public class MemberController {

    @Controller
    @RequestMapping("/user")
    public class MemberController {

        private final Logger log = LoggerFactory.getLogger(this.getClass());
        private final PasswordEncoder passwordEncoder;
        private final MemberServiceImpl memberService;

        public MemberController(PasswordEncoder passwordEncoder, MemberServiceImpl memberService) {
            this.passwordEncoder = passwordEncoder;
            this.memberService = memberService;
        }

        @GetMapping("/signup")
        public String goRegister() {
            return "content/member/regist";
        }

        @PostMapping("/regist")
        public String registMember(@ModelAttribute MemberDTO member, HttpServletRequest request, RedirectAttributes rttr) throws MemberRegistException {

            log.info("");
            log.info("");
            log.info("[MemberController] registMember ==========================================================");

            String address = request.getParameter("zipCode") + "$" + request.getParameter("address1") + "$" + request.getParameter("address2");
            member.setPhone(member.getPhone().replace("-", ""));
            member.setAddress(address);
            member.setMemberPwd(passwordEncoder.encode(member.getMemberPwd()));

            log.info("[MemberController] registMember request Member : " + member);

            memberService.registMember(member);

            rttr.addFlashAttribute("message", "회원 가입에 성공하였습니다.");

            log.info("[MemberController] registMember ==========================================================");

            return "redirect:/";
        }

        @PostMapping("/idDupCheck")
        public ResponseEntity<String> checkDuplication(@RequestBody MemberDTO memberDto) throws JsonProcessingException {

            log.info("");
            log.info("");
            log.info("[MemberController] checkDuplication ==========================================================");

            String result = "사용 가능한 아이디 입니다.";
            log.info("[MemberController] Request Check ID : " + memberDto.getMemberId());

            if("".equals(memberDto.getMemberId())) {
                log.info("[MemberController] No Input Member ID");
                result = "아이디를 입력해 주세요";
            } else if(memberService.selectMemberById(memberDto.getMemberId())) {
                log.info("[MemberController] Already Exist");
                result = "중복된 아이디가 존재합니다.";
            }

            log.info("[MemberController] checkDuplication ==========================================================");

            return ResponseEntity.ok(result);
        }


        @GetMapping("/login")
        public String goLogin() {

            return "content/member/login";
        }


        @GetMapping("/loginfail")
        public String goLoginFail() {

            return "errors/login";
        }

        @GetMapping("/update")
        public String goModifyMember() {

            return "content/member/update";
        }

        @PostMapping("/update")
        public String modifyMember(@ModelAttribute MemberDTO member, HttpServletRequest request, HttpServletResponse response, RedirectAttributes rttr) throws MemberModifyException {

            log.info("");
            log.info("");
            log.info("[MemberController] modifyMember ==========================================================");

            String address = request.getParameter("zipCode") + "$" + request.getParameter("address1") + "$" + request.getParameter("address2");
            member.setPhone(member.getPhone().replace("-", ""));
            member.setAddress(address);
            member.setMemberPwd(passwordEncoder.encode(member.getMemberPwd()));

            log.info("[MemberController] modifyMember request Member : " + member);

            memberService.modifyMember(member);

            // 회원정보 수정후 로그아웃 프로세스 진행
            SessionUtil.invalidateSession(request, response);

            rttr.addFlashAttribute("message", "회원 정보 수정에 성공하셨습니다. 다시 로그인해주세요.");

            log.info("[MemberController] modifyMember ==========================================================");

            return "redirect:/";
        }

        @GetMapping("/delete")
        public String deleteMember(@ModelAttribute MemberDTO member, SessionStatus status
                , RedirectAttributes rttr, HttpServletRequest request, HttpServletResponse response) throws MemberRemoveException {

            log.info("");
            log.info("");
            log.info("[MemberController] deleteMember ==========================================================");

            String memberId = request.getParameter("id");
            member.setMemberId(memberId);

            log.info("[MemberController] member : " + member);
            memberService.removeMember(member);

            // 회원 탈퇴후 로그아웃 프로세스 진행
            SessionUtil.invalidateSession(request, response);

            rttr.addFlashAttribute("message", "회원 탈퇴에 성공하셨습니다. 로그아웃됩니다.");

            log.info("[MemberController] deleteMember ==========================================================");

            return "redirect:/";
        }
}
