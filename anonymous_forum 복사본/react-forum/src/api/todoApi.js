import axios from 'axios';

// export const API_SERVER_HOST = `${process.env.REACT_APP_API_SERVER_HOST}`;

//----------- 게시판 관련 CRUD
const boardPrefix = ` ${process.env.REACT_APP_API_SERVER_HOST}`;
console.log(boardPrefix);

// Get
// 카테고리별 게시판 가져오기
// http://172.16.1.217:8080/api/list/1

// 게시글 상세보기
// 8080/api/detailed/1
// /api
// /api/category

// Post
// 8080/api/register

// Put
// 8080/api/modify

// export const getCategory = async (code) => {
//   const res = await axios.get(`${boardPrefix}/api/${code}`);

//   return res.data;
// };

// 게시판 글 목록 1개 가져오기
export const getOne = async (tno) => {
  const res = await axios.get(`${boardPrefix}/api/detailed/${tno}`);
  return res.data;
};

// 게시판 글 목록 모두 가져오기
export const getList = async () => {
  const res = await axios.get(`${boardPrefix}/api`);

  return res.data;
};

// 게시판 글 추가
export const postAdd = async (todoObj) => {
  const res = await axios.post(`${boardPrefix}/api/register`, {
    title: todoObj.title,
    writer: todoObj.writer,
    password: todoObj.password,
    content: todoObj.content,
    category: todoObj.category,
    regDate: todoObj.category,
  });
  return res.data;
};

// 게시판 글 수정
export const putOne = async (todo) => {
  const res = await axios.put(`${boardPrefix}/${todo.tno}`, {
    title: todo.title,
    content: todo.content,
    wrtiter: todo.writer,
    pwd: todo.pwd,
  });
  return res.data;
};

// 게시판 글 삭제
export const deleteOne = async (tno) => {
  const res = await axios.delete(`${boardPrefix}/${tno}`);
  return res.data;
};

//----------- 댓글 관련 CRUD
const commentPrefix = `${boardPrefix}/comment`;

// 댓글 전체 가져오기
export const getComment = async () => {
  const result = await fetch(`${commentPrefix}`);
  const res = await result.json();
  return res;
};

// 댓글 추가
export const postComment = async (obj) => {
  const result = await fetch(`${commentPrefix}/`, {
    method: 'POST',
    body: JSON.stringify({
      content: obj.content,
      writer: obj.writer,
      regDate: obj.regDate,
      boardId: 1,
      pwd: obj.pwd,
    }),
    headers: {
      'content-type': 'application/json',
    },
  });

  const res = await result.json();
  return res;
};

// 댓글 수정
export const putComment = async (obj) => {
  const result = await fetch(`${commentPrefix}/${obj.tno}`, {
    method: 'PUT',
    body: JSON.stringify({
      content: obj.content,
      wrtiter: obj.writer,
      regDate: obj.regDate,
      pwd: obj.pwd,
    }),
    headers: {
      'content-type': 'application/json',
    },
  });

  const res = result.json();
  return res;
};

// 댓글 삭제
export const deleteComment = async (tno) => {
  const result = await fetch(`${commentPrefix}/${tno}`, {
    method: 'DELETE',
  });

  const res = result.json();
  return res;
};

// 카테고리
const categoryPrefix = `${boardPrefix}/api/category`;

// 댓글 전체 가져오기

export const getCategory = async (code) => {
  const res = await axios.get(`${categoryPrefix}/${code.code}`);
  return res.data;
};

/*
import axios from "axios"

//서버 주소
export const API_SERVER_HOST = 'http://localhost:8080'

const prefix = `${API_SERVER_HOST}/api/todo`

export const getOne = async (tno) => {
  const res = await axios.get(`${prefix}/${tno}` )

  return res.data
}

export const getList = async ( pageParam ) => {
  const {page,size} = pageParam
  const res = await axios.get(`${prefix}/list`, {params: {page:page,size:size }})
  
  return res.data
}

export const postAdd = async (todoObj) => {
  const res = await axios.post(`${prefix}/` , todoObj)

  return res.data
}

export const deleteOne = async (tno) => {
  const res = await axios.delete(`${prefix}/${tno}` )

  return res.data
}

export const putOne = async (todo) => {
  const res = await axios.put(`${prefix}/${todo.tno}`, todo)

  return res.data
}
*/
