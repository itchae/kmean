## Copyright (C) 2018 Tom
## 
## This program is free software; you can redistribute it and/or modify it
## under the terms of the GNU General Public License as published by
## the Free Software Foundation; either version 3 of the License, or
## (at your option) any later version.
## 
## This program is distributed in the hope that it will be useful,
## but WITHOUT ANY WARRANTY; without even the implied warranty of
## MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
## GNU General Public License for more details.
## 
## You should have received a copy of the GNU General Public License
## along with this program.  If not, see <http://www.gnu.org/licenses/>.

## -*- texinfo -*- 
## @deftypefn {} {@var{retval} =} generation-data (@var{input1}, @var{input2})
##
## @seealso{}
## @end deftypefn

## Author: Tom <tom@tom-HP-ProBook-450-G0>
## Created: 2018-11-06

function generation_data
    x1=[randn(1,128)+4;randn(1,128)+4];
    x2=[randn(1,128)*2-4;randn(1,128)*2-4];
    x=[x1 x2];
    clas = [ones(1,128) ones(1,128)*2];
    save data-gen.txt x -ascii;
    save oracle.txt clas -ascii;
endfunction
