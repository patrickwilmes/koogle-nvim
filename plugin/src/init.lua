--
-- Copyright (c) 2024, Patrick Wilmes <p.wilmes89@gmail.com>
-- All rights reserved.
--
-- SPDX-License-Identifier: BSD-2-Clause
--

-- your_plugin.lua

local M = {}

-- Function to insert a line into the current buffer
function M.insert_line()
    local current_buf = vim.api.nvim_get_current_buf()  -- Get the current buffer
    local current_line = vim.api.nvim_win_get_cursor(0)[1]  -- Get the current line number

    vim.api.nvim_buf_set_lines(current_buf, current_line, current_line, false, {"Hello from Lua!"})
end

-- Function to replace the entire buffer content
function M.replace_buffer()
    local current_buf = vim.api.nvim_get_current_buf()  -- Get the current buffer

    local lines = {
        "This is line 1",
        "This is line 2",
        "Hello, Neovim!",
        "This is line 4"
    }

    vim.api.nvim_buf_set_lines(current_buf, 0, -1, false, lines)
end

return M
